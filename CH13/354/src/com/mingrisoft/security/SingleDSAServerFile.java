/**
 * @jdk版本:1.6
 * @寫程式時間:2010-3-20
 */
package com.mingrisoft.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
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

/**
 * @author bwm
 * 
 */
public class SingleDSAServerFile {

	static String algorithm = "DSA";

	static String signdataFile = "fileSignData.dat";
	static String privatekeyFile = "keyPrivateData.dat";
	static String publickeyFile = "keyPublicData.dat";

	/**
	 * 產生密鑰對
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public void generatorKey() {
		KeyPairGenerator generator = null;
		try {
			generator = KeyPairGenerator.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KeyPair keyPair = generator.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		writeFile(publicKey.getEncoded(), publickeyFile);
		writeFile(privateKey.getEncoded(), privatekeyFile);
	}

	/**
	 * 產生簽名
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws InvalidKeyException 
	 * @throws SignatureException 
	 */
	public void generatorSign(byte[] data) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {

		byte[] privateKey = readFile(privatekeyFile);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);

		// algorithm 指定的加密算法
		KeyFactory keyFactory = null;
		PrivateKey priKey = null;
		keyFactory = KeyFactory.getInstance(algorithm);
		priKey = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance(keyFactory.getAlgorithm());
		signature.initSign(priKey);
		signature.update(data);
		writeFile(signature.sign(), signdataFile);
	}

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

	public static void main(String[] avg) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {

		SingleDSAServerFile singleDSAServerFile = new SingleDSAServerFile();
		SingleDSAClientFile singleDSAClientFile = new SingleDSAClientFile();
		String data = "明日科技";
		System.out.println("傳輸資料：" + data);
		boolean flag = false;

		singleDSAServerFile.generatorKey();
		singleDSAServerFile.generatorSign(data.getBytes());

		flag = singleDSAClientFile.verifySign(data.getBytes());

		if (flag) {
			System.out.println("驗證透過，資料傳輸過程沒有經過修改");
		} else {
			System.out.println("驗證不過通，資料傳輸過程經過修改");
		}
	}
}
