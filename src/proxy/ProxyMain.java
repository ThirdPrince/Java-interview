package proxy;

import com.sun.tools.javac.Main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyMain {
    private Button button = new Button();

    public ProxyMain() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        init();
    }
    public void onClick(){
        System.out.println("onClick");
    }
    public void init() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        OnClickListenerHandler handler = new OnClickListenerHandler(this);
        Method method = ProxyMain.class.getMethod("onClick");
        handler.addMethod("onClick",method);
        Object clickProxy = Proxy.newProxyInstance(OnClickListener.class.getClassLoader(),new Class<?>[]{
                OnClickListener.class
        },handler);
        Method clickMethod = button.getClass().getMethod("setOnClickListener",OnClickListener.class);
        clickMethod.invoke(button,clickProxy);

    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ProxyMain proxyMain = new ProxyMain();
        proxyMain.button.click();

    }
}

class OnClickListenerHandler implements InvocationHandler{

    private Object targetObject;
    public OnClickListenerHandler(Object object){
        this.targetObject = object;
    }


    private Map<String,Method> methods = new HashMap<String,Method>();

    public void addMethod(String methodName,Method method){
        methods.put(methodName,method);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String methodName = method.getName();
        Method realMethod = methods.get(methodName);
        return realMethod.invoke(targetObject,objects);
    }
}

class Button{
    private OnClickListener listener;
    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }
    public void click(){
        if(listener != null){
            listener.onClick();
        }
    }

}
interface OnClickListener{
    void  onClick();
}
