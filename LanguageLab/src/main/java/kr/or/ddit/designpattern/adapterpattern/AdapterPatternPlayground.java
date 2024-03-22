package kr.or.ddit.designpattern.adapterpattern;

import kr.or.ddit.designpattern.adapterpattern.obj.Adaptee;
import kr.or.ddit.designpattern.adapterpattern.obj.Adapter;
import kr.or.ddit.designpattern.adapterpattern.obj.Client;

public class AdapterPatternPlayground {
	public static void main(String[] args) {
		Client client = new Client();
		client.setTarget(new Adapter(new Adaptee(new (new (new..)))));
		client.getTarget().request();
	}
}
