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
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @author baiweiming
 * 
 */
public class BothRSAClientFile {

	private String keyAlgorithm = "RSA";
	private String singAlgorithm = "MD5withRSA";
	// 服務端資料檔案
	private String serverdataFile = "fileServerData.dat";
	// 客戶端資料檔案
	private String clientdataFile = "fileClientData.dat";
	// 簽名檔案
	private String signdataFile = "fileSignData.dat";
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
	 * 驗證數字簽名
	 * 
	 * @return 驗證成功傳回true 失敗傳回false
	 */
	public boolean verifySign() {
		byte[] data = readFile(serverdataFile);
		byte[] publicKey = readFile(publickeyFile);
		byte[] sign = readFile(signdataFile);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory keyFactory = null;
		PublicKey pubKey = null;
		try {
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			pubKey = keyFactory.generatePublic(keySpec);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// 驗證簽名是否正常
			Signature signature = Signature.getInstance(singAlgorithm);
			signature.initVerify(pubKey);
			signature.update(data);
			return signature.verify(sign);
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 用公鑰解密
	 * 
	 * @return
	 */
	public byte[] decryptByPublicKey() {
		byte[] data = readFile(serverdataFile);
		byte[] key = readFile(publickeyFile);
		// 取得公鑰
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
		KeyFactory keyFactory = null;
		Key publicKey = null;
		try {
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			publicKey = keyFactory.generatePublic(x509KeySpec);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 對資料解密
		try {
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用公鑰加密
	 */
	public void encryptByPublicKey(byte[] data) {
		byte[] key = readFile(publickeyFile);
		// 取得公鑰
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
		KeyFactory keyFactory = null;
		Key publicKey = null;
		try {
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			publicKey = keyFactory.generatePublic(x509KeySpec);
		} catch (InvalidKeySpecException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 對資料加密
		try {
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			writeFile(cipher.doFinal(data), clientdataFile);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] arg) {
		BothRSAClientFile bothRSAClientFile = new BothRSAClientFile();
		BothRSAServerFile bothRSAServerFile = new BothRSAServerFile();

		String cdata = "服務端你好，這裡是客戶端";
		bothRSAClientFile.encryptByPublicKey(cdata.getBytes());
		byte [] cdata1 = bothRSAServerFile.decryptByPrivateKey();
		System.out.println("Client原始資料："+cdata);
		System.out.println("Servet解密資料："+new String (cdata1));
		
	}

}
