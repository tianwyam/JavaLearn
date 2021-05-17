package com.tianya.java.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import lombok.Builder;
import lombok.Data;

/**
 * @Description: 
 * 序列化对象 方式二：实现接口
 * @author: TianwYam
 * @date 2021年5月17日 下午9:23:14
 */
@Data
@Builder
public class People implements Externalizable{
	

	private int pid ;
	
	private String name ;
	
	private String addr ;
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// 可以自定义 写入对象
		out.writeObject(this.pid);
		out.writeObject(this.name);
		out.writeObject(this.addr);
		System.out.println("方式二：");
		System.out.println("序列化");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// 读出对象
		System.out.println("方式二：");
		System.out.println("反序列化");
		this.pid = (Integer)in.readObject();
		this.name = (String)in.readObject();
		this.addr = (String)in.readObject();
	}

	@Override
	public String toString() {
		return "People [pid=" + pid + ", name=" + name + ", addr=" + addr + "]";
	}
	
	

	public People(int pid, String name, String addr) {
		this.pid = pid;
		this.name = name;
		this.addr = addr;
	}

	public People() { }
	
	

}
