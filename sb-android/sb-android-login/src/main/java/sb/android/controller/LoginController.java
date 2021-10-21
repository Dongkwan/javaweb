package sb.android.controller;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class LoginController {
		@RequestMapping(value= "/login", method = {RequestMethod.POST})
		public String androidPage(HttpServletRequest request, Model model) {
			System.out.println("안드로이드 접속 요청 처리");
			try{
					String androidID = request.getParameter("id");
					String androidPW = request.getParameter("pw");
					System.out.println("안드로이드에서 받아온 id : " + androidID);
					System.out.println("안드로이드에서 받아온 pw : " + androidPW);
					//model.addAttribute("android", androidID);
					return "LoginOkay"; //서버로 login okay 전송....
			}catch (Exception e){
					e.printStackTrace();
					return "null";
			}
		}
}
