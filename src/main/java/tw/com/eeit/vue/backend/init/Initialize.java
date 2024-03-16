package tw.com.eeit.vue.backend.init;

import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class Initialize implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
	}

	private List<Object> readFromJson(){
		
		return null;}
}
