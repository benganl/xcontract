package za.co.wyzetech.cms.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component("taskListener")
public class TaskListener {

    public void call(Object execution) {
        Class<?>[] interfaces = execution.getClass().getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);
        log.info(":::::::::::::::::: Task Listener ::::::::::::::::::");
    }
}
