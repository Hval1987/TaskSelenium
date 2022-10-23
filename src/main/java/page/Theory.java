пакет com.cyborg.core.generic.dataUtils;
импортировать java.io.FileInputStream;
импортировать java.io.FileNotFoundException;
импортировать java.io.IOException;
импортировать java.io.InputStream;
импортировать java.util.LinkedHashMap;
импортировать java.util.Properties;
импортировать java.util.Set;импортировать org.apache.log4j.PropertyConfigurator; // Этоpu класс SingleTon blic
class PropertiesDataUtils {
    private Properties properties = null;
    публичный статический LinkedHashMap configDataStore = новый LinkedHashMap (); Входной поток равен нулю; // Это статическая и приватная ссылка на класс, которую вы можете использовать в любом месте вашего фреймворка private static PropertiesDataUtils propertiesDataUtils = null; логическое значение centralizeLog = false; // Это закрытый конструктор для создания объекта, но вы не можете получить к нему доступ извне класса, чтобы поддерживать дизайн шаблона SingleTon, т.е. создавать только один объект.
private PropertiesDataUtils(String filePath){generateDataStore(filePath);
CentralizeLog=Boolean.parseBoolean(PropertiesDataUtils.configDataStore.get("centralizedLog"));
if(centralizeLog)PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//test//resources//config//log4j_central.properties");else PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//test//resources//config//log4j_local.properties");}private PropertiesDataUtils(){} // Этот метод в основном создает экземпляр класса SingleTon public static PropertiesDataUtils getInstance(String filePath) { if (propertiesDataUtils == null) propertiesDataUtils = new PropertiesDataUtils(filePath); вернуть свойстваDataUtils; } // этот метод в основном создает хранилище данных, в котором вы хотите хранить все данные конфигурации, как обсуждалось ранее private void generateDataStore(String filePath) { try { this.properties = new Properties(); = новый FileInputStream (filePath); свойства.load(есть); переопределить из среды (); Установлен ключи = загрузитьВсеКлючи(); for (Объект k: ключи) { String key = (String) k; configDataStore.put (ключ, getPropertyValue (ключ)); } } catch (FileNotFoundException fileNotFoundException) { String exceptionData = String.valueOf(fileNotFoundException.getCause().getMessage()); } catch (IOException ioException) { String exceptionData = String.valueOf(ioException.getCause().getMessage()); } наконец { if (null!= is) { try { is.close(); } catch (Exception e) { String exceptionData = String.valueOf(e.getCause().getMessage()); } } } } // Этот метод используется для загрузки всех ключей из файла свойств.