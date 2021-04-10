package Achitecture.Lesson6;

import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {
    private static final ThreadLocal current = new ThreadLocal();

    public static void newCurrent(){
        setCurrent(new UnitOfWork());
    }
    public static void setCurrent(UnitOfWork unitOfWork){
        current.set(unitOfWork);
    }
    public static UnitOfWork getCurrent(){
        return (UnitOfWork) current.get();
    }
    private List<Client> newObjs = new ArrayList<>();
    public void regisertNew(Client object){
        newObjs.add(object);
    }

    public List<Client> getNewObjs(){
        return newObjs;
    }
    public void commit(){
        checkNewEmptyNameObject();
    }
    public void checkNewEmptyNameObject(){
        newObjs.removeIf(client -> client.getName().isEmpty());
    }
}
