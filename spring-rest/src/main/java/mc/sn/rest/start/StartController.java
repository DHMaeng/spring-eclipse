package mc.sn.rest.start;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StartController {
	
	private static final Logger logger = LoggerFactory.getLogger(StartController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String start(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "start";
	}
	
	@RequestMapping(value = "/res1")
	@ResponseBody
	public String res1(@RequestParam("userId") String userId, 
	           HttpServletRequest request, HttpServletResponse response) {
			System.out.println("userId "+userId);
		return userId;
	}
	
}
