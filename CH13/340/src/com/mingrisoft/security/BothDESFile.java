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
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author bwm
 * 
 */
public class BothDESFile {

	String algorithm = "DES";
	// key儲存的檔案名稱
	String keyFile = "keyData.dat";
	// 資料儲存的檔案名稱
	String dataFile = "fileData.dat";

	public BothDESFile() {
		try {
			initKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 產生密鑰資料,儲存到檔案中
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	private void initKey() throws NoSuchAlgorithmException {
		// 產生一個隨機數源
		SecureRandom secureRandom = new SecureRandom();
		// 為DES算法產生一個KeyGenerator
		KeyGenerator generator = KeyGenerator.getInstance(algorithm);
		generator.init(secureRandom);
		SecretKey key = generator.generateKey();
		//產生密鑰資料,儲存到檔案中
		writeFile(key.getEncoded(), keyFile);

	}

	/**
	 * 轉化密鑰成Key進行加密解密
	 * 
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private Key toKey() throws InvalidKeyException, NoSuchAlgorithmException,
			InvalidKeySpecException {
		byte[] key = readFile(keyFile);
		DESKeySpec keySpec = new DESKeySpec(key);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
		SecretKey secretKey = factory.generateSecret(keySpec);
		return secretKey;
	}

	/**
	 * 加密，把加密資料儲存在檔案中
	 * 
	 * @param data
	 * @param key
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public void encrypt(byte[] data) throws InvalidKeyException,
			NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		Key key = toKey();
		// 使用Cipher實際完成加密操作
		Cipher cipher = Cipher.getInstance(algorithm);
		// 使用密鑰初始化Cipher
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] f = cipher.doFinal(data);
		writeFile(f, dataFile);
	}

	/**
	 * 解密把資料從檔案中取出來在解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decrypt() throws InvalidKeyException,
			NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		Key key = toKey();
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] f = readFile(dataFile);
		return new String(cipher.doFinal(f));
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

	public static void main(String[] avg) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		BothDESFile bothDESFile = new BothDESFile();
		String data = "明日科技";

		// 資料加密
		System.out.println("加密前：" + data);
		bothDESFile.encrypt(data.getBytes());

		// 資料解密
		String b = bothDESFile.decrypt();
		System.out.println("解密後：" + b);

	}
}
