package hello.login.converter;

import org.springframework.core.convert.support.DefaultConversionService;

public class ConverterTest {

    public static void main(String[] args) {

//        StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter();
//        Integer convert = stringToIntegerConverter.convert("22");
//        System.out.println("convert = " + convert);
;

        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());

//        Integer convert = conversionService.convert("10", Integer.class);
        IpPort convert2 = conversionService.convert("local:8080", IpPort.class);
        System.out.println("convert2 = " + convert2);

    }

}
