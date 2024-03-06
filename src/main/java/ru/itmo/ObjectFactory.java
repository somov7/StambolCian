package ru.itmo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/*
    Это не имеет прямого отношения к лабе, я просто пытался объяснить, как написать DI самому, и этот класс даже
    не решает данную задачу (зато решает задачу синглтонов)
 */
public class ObjectFactory {

    private static Map<Class<?>, Object> singletons = new ConcurrentHashMap<>();

    public static <T> T getSingleton(Class<T> clazz, Supplier<T> objectSupplier) {
        Object object = singletons.get(clazz);
        if (object == null) { // https://www.baeldung.com/java-singleton-double-checked-locking
            synchronized (clazz) {
                Object localObject = singletons.get(clazz);
                if (localObject == null) {
                    localObject = objectSupplier.get();
                    singletons.put(clazz, localObject);
                }
                return (T) localObject;
            }
        }
        return (T) object;
    }
}
