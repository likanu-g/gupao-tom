package com.gupaoedu.vip.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * // ��̬�����ص㣺
	//�ع�һ�£��������ģʽӦ�ó�����������Ҫ��������ȡ��
	//1��������ɫ��ִ���ߡ�����������
	//2��ע�ع��̣�����Ҫ��������������ûʱ�������߲������������ߣ�����רҵ
	//3��ִ���߱����õ�����������ĸ������ϣ�ִ���߳��б�������������ã�
 * @author Administrator
 *
 */
public class GPMeipo implements MethodInterceptor{

	//���ʣ�
	//����û�г��б��������������
	public Object getInstance(Class clazz) throws Exception{
		
		Enhancer enhancer = new Enhancer();
		//�Ѹ�������Ϊ˭��
		//��һ�����Ǹ���cglib�����ɵ�������Ҫ�̳��ĸ���
		enhancer.setSuperclass(clazz);
		//���ûص�������this��Ϊ���ܹ��ص��˶����intercept����
		enhancer.setCallback(this);
		
		//��һ��������Դ����
		//�ڶ����������class�ļ�
		//�����������ص�JVM�У������ر���������
		return enhancer.create();
	}
	
	//ͬ���������ֽ�����������һ������
	//����ʹ��API���û���˵�����޸�֪
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("����GPý�ţ�" + "�ø����Ҹ����Բ���");
		System.out.println("��ʼ���к�ѡ...");
		System.out.println("------------");
		//���obj����������CGLib������new������
		//cglib new�����Ժ�Ķ����Ǳ�������������ࣨ�̳��������Լ�д���Ǹ��ࣩ
		//OOP, ��new����֮ǰ��ʵ����Ĭ���ȵ���������super()�����ģ�
		//new�������ͬʱ��������new�������࣬����൱���Ǽ�ӵĳ��������Ǹ��������
		//������д�˸�������еķ���
		//���Ǹı���������ĳЩ���ԣ��ǿ��Լ�ӵĲ�����������Ե�
		//������ø��෽�����൱��ִ�б��������ԭ����
		proxy.invokeSuper(obj, args);
		System.out.println("------------");
		System.out.println("������ʵĻ�����׼������");
		return null;
	}

}