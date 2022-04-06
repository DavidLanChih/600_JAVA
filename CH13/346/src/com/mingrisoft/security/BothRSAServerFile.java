/**
 *second 
 */
package com.mingrisoft.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @author baiweiming
 * 
 */
public class BothRSAServerFile {

	private String keyAlgorithm = "RSA";
	private String singAlgorithm = "MD5withRSA";
	// 服務端資料檔案
	private String serverdataFile = "fileServerData.dat";
	// 客戶端資料檔案
	private String clientdataFile = "fileClientData.dat";
	// 簽名檔案
	private String signdataFile = "fileSignData.dat";
	// 私鑰檔案
	private String privatekeyFile = "keyPrivateData.dat";
	// 公鑰檔案
	private String publickeyFile = "keyPublicData.dat";

	/**
	 * 把資料寫到指定的檔案上
	 * 
	 * @param data
	 *            資料
	 * @param fileName
	 *            檔案名稱
	 */
	public void writeFile(byte[] data, String fileName) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			fileOutputStream.write(data);
			fileOutputStream.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根據fileName讀取資料檔案
	 * 
	 * @param fileName
	 * @return
	 */
	public byte[] readFile(String fileName) {

		// 讀取
		try {
			File file = new File(fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fileInputStream.read(data);
			fileInputStream.close();
			return data;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 產生密鑰對
	 */
	public void generateKeyFile() {
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance(keyAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KeyPair keyPair = keyPairGen.generateKeyPair();

		// 公鑰
		PublicKey publicKey = keyPair.getPublic();
		writeFile(publicKey.getEncoded(), publickeyFile);

		// 私鑰
		PrivateKey privateKey = keyPair.getPrivate();
		writeFile(privateKey.getEncoded(), privatekeyFile);
	}

	/**
	 * 用私鑰加密
	 * 
	 * @param data
	 * @return
	 */
	public void encryptByPrivateKey(byte[] data) {

		// 取得私鑰
		byte[] key = readFile(privatekeyFile);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory = null;
		Key privateKey = null;
		try {
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 對資料加密
		try {
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			writeFile(cipher.doFinal(data), serverdataFile);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 用私鑰對資訊產生數字簽名
	 * 
	 * @param data
	 *            加密資料
	 * @param privateKey
	 *            私鑰
	 * 
	 * @return
	 * @throws Exception
	 */
	public void generateSign() {

		byte[] privateKey = readFile(privatekeyFile);
		byte[] serverData = readFile(serverdataFile);
		// 建構PKCS8EncodedKeySpec對像
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);

		// KEY_ALGORITHM 指定的加密算法
		KeyFactory keyFactory = null;
		PrivateKey priKey = null;
		try {
			//產生私鑰
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			priKey = keyFactory.generatePrivate(pkcs8KeySpec);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			//產生數字簽名
			Signature signature = Signature.getInstance(singAlgorithm);
			signature.initSign(priKey);
			signature.update(serverData);
			writeFile(signature.sign(), signdataFile);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 用私鑰解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public byte[] decryptByPrivateKey() {
		byte[] data = readFile(clientdataFile);
		byte[] key = readFile(privatekeyFile);
		// 取得私鑰
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory = null;
		Key privateKey = null;
		try {
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return cipher.doFinal(data);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] arg) {
		String data = "客戶端你好，我是服務端";
		// 服務端操作
		BothRSAServerFile bothRSAServerFile = new BothRSAServerFile();
		// 產生密鑰對
		bothRSAServerFile.generateKeyFile();
		// 加密明文
		bothRSAServerFile.encryptByPrivateKey(data.getBytes());
		// 產生簽名
		bothRSAServerFile.generateSign();

		// 客戶端操作
		BothRSAClientFile bothRSAClientFile = new BothRSAClientFile();

		byte[]  data1 =null;
		if(bothRSAClientFile.verifySign()){
			data1= bothRSAClientFile.decryptByPublicKey();
		}
		System.out.println("Servet原始資料："+data);
		System.out.println("Client解密資料："+new String (data1));
		
	}

}
