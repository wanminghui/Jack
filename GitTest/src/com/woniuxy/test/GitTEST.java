package com.woniuxy.test;


/*

分支管理
  git在管理项目的时候，至少有一个分支master（主干）
  主干的作用;主要是提供公共的的代码，一般的程序不要去对其进行修改
  一般情况下有项目经理，组长配置好环境后推送到远程仓库 这些代码作为master
  其他的程序员组员应该在该分支以外的其他分支进行各自的开发
  比如说宿舍管理系统的 模块；张三的，应该新建一个一个分支 branch-张三，然后再
  该分支上进行代码编写，新建分支相当于复制了一份master的代码
  
  
*/

public class GitTEST {
	public static void main(String[] args) {
		System.out.println("这是一个程序，需要你来实现它！");
	}

	public void run(){
		
		System.out.println("hello word");
		
	}
	
public void function2(){
		
		System.out.println("第三个！");
		
	}
	
public void fun6(){
	
	System.out.println("分支！");
}

public void fun7(){
	
	System.out.println("这是 属于万明辉的一个分支的功能！s！");
}

}
