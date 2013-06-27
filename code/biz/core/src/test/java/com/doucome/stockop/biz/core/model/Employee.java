package com.doucome.stockop.biz.core.model;

import java.net.Socket;
/**
 * ��c����ͨ��(java��client��c/c++��server������һ���ṹ)
 * 
 * @author kingfish
 * @version 1.0
 */
public class Employee {
	private byte[] buf = new byte[28]; // Ϊ˵�����⣬������С���¼��п�������

	/**
	 * ��intתΪ���ֽ���ǰ�����ֽ��ں��byte����
	 */
	private static byte[] tolh(int n) {
		byte[] b = new byte[4];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 & 0xff);
		b[2] = (byte) (n >> 16 & 0xff);
		b[3] = (byte) (n >> 24 & 0xff);
		return b;
	}
	/**
	 * ��byte����ת����String
	 */
	private static String toStr(byte[] valArr,int maxLen) {
		int index = 0;
		while(index < valArr.length && index < maxLen) {
			if(valArr[index] == 0) {
				break;
			}
			index++;
		}
		byte[] temp = new byte[index];
		System.arraycopy(valArr, 0, temp, 0, index);
		return new String(temp);
	}
	
	/**
	 * �����ֽ���ǰתΪint�����ֽ��ں��byte����
	 */
	private static int vtolh(byte[] bArr) {
		int n = 0;
		for(int i=0;i<bArr.length&&i<4;i++){
			int left = i*8;
			n+= (bArr[i] << left);
		}
		return n;
	}
	public String name = "";
	public int id = 0;
	public float salary = 0;
	/**
	 * ��floatתΪ���ֽ���ǰ�����ֽ��ں��byte����
	 */
	private static byte[] tolh(float f) {
		return tolh(Float.floatToRawIntBits(f));
	}
	
	private static Employee getEmployee(byte[] bArr) {
		String name = "";
		int id = 0;
		float salary = 0;
		
		byte[] temp = new byte[20];
		name = toStr(bArr,20);
		
		System.arraycopy(bArr, 20, temp, 0, 4);
		id = vtolh(temp);
		
		return new Employee(name, id, salary);
		

	}
	/**
	 * ���첢ת��
	 */
	public Employee(String name, int id, float salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		
		byte[] temp = name.getBytes();
		System.arraycopy(temp, 0, buf, 0, temp.length);

		temp = tolh(id);
		System.arraycopy(temp, 0, buf, 20, temp.length);

		temp = tolh(salary);
		System.arraycopy(temp, 0, buf, 24, temp.length);
	}
	
	/**
	 * ����Ҫ���͵�����
	 */
	public byte[] getbuf() {
		return buf;
	}

	/**
	 * ���Ͳ���
	 */
	public static void main(String[] args) {
		try {
			int index = 0;
			byte[] receive = new byte[28];
			int k=15;
			while(k>0){
				Socket sock = new Socket("127.0.0.1", 5050);
				System.out.println("send content:  name=kingfish  "+"value="+(1+index));
				sock.getOutputStream().write(new Employee("kingfish"+index, 1+index++, 10.99f + index).getbuf());
				sock.getInputStream().read(receive);
				Employee ee = getEmployee(receive);
				System.out.println("    response:  name="+ee.name+"  "+"value="+ee.id);
				k--;
				sock.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} // end 