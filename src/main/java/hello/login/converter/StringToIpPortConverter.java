package hello.login.converter;

import org.springframework.core.convert.converter.Converter;

public class StringToIpPortConverter implements Converter<String, IpPort> {

    @Override
    public IpPort convert(String source) {

        //localhost:8080
        String[] split = source.split(":");
        IpPort ipPort = new IpPort(split[0], Integer.parseInt(split[1]));

        return ipPort;
    }
}
