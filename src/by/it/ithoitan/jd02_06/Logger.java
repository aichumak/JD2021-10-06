package by.it.ithoitan.jd02_06;
/*
Необходимо создать логгер выводящий сообщения об ошибках и событиях в текстовый файл.
Объект логгера должен быть создан с помощью шаблона проектирования Singleton (ленивый
и потокобезопасный – на lock-ах). Он должен имплементировать интерфейс Log с методами
error(сообщения об ошибке) и info(сообщение) и записывающий его в файл вместе с
информацией о типе, дате, времени и тексте происшествия. Файл имеет имя log.txt и
располагается в том же каталоге, что и исходный код класса Singleton.
 */
public class Logger implements Log {
    private static volatile Logger logger;

    public Logger() {
    }
    public static Logger getLogger(){
        Logger localLogger = logger;
        if(localLogger==null){
            synchronized (Logger.class){
                localLogger=logger;
                if(localLogger==null){
                    logger=localLogger=new Logger();
                }
            }
        }
        return localLogger;
    }

    @Override
    public void error() {

    }

    @Override
    public void info() {

    }
}
