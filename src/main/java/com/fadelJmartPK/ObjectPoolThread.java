package com.fadelJmartPK;

import java.util.Vector;
import java.util.function.Function;

public class ObjectPoolThread<T> extends Thread{
	private boolean exitSignal = false;
	private Vector<T> objectPool;
	private Function<T, Boolean> routine;
	
	public ObjectPoolThread(String name, Function<T, Boolean> routine) {
		super(name);
		this.routine = routine;
	}
	public ObjectPoolThread(Function<T, Boolean> routine) {
		this.routine = routine;
	}
	
	public synchronized void add(T object) {
		objectPool.add(object);
	}
	@SuppressWarnings("deprecation")
	public synchronized void exit() {
		exitSignal = true;
	}
	@ Override
	public void run ()
    {
        exitSignal = false;

        for(int i = 0; i < this.size(); i++)
        {
            T object = objectPool.get(i);
            boolean temp = routine.apply(object);
            if(!temp) this.objectPool.add(object);
            while(this.objectPool == null)
            {
                try{
                    routine.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            if(exitSignal)
            {
                break;
            }
        }

    }
	public int size() {
		return objectPool.size();
		
	}
}
