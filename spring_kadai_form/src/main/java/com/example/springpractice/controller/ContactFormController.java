package com.example.springpractice.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springpractice.form.ContactForm;

@Controller
public class ContactFormController {
	//お問い合わせ画面表示
	@GetMapping("/form")
	public String form(Model model) {
		//もし, インスタンスが存在しない場合は生成
		if(!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm", new ContactForm());
		}
		System.out.println("formまで来ました");
		return "contactFormView";
	}
	//確認画面表示
	@PostMapping("/confirm")
	public String confirm(RedirectAttributes redirectAttributes,
			@Validated ContactForm form,BindingResult result) {
		//エラー情報を保持しているか否か
		if(result.hasErrors()) {
			//エラー情報を持つならばフォームクラス(入力された値を格納)をビューに渡す
			//(addFlashAttribute()メソッドにてリダイレクト後のリクエストに値を返せる)
			redirectAttributes.addFlashAttribute("contactForm", form);
			//バリデーション結果をビューに受け渡す
			//フォームクラスを参照し. 名称をSpringBootで有効な形に変換(大文字, 小文字の参照ミスを防げる)
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
					+ Conventions.getVariableName(form), result);
			//エラーがあった時はformにリダイレクト
			return "redirect:/form";
		}
		//エラーがなかった時はデータを保持して画面遷移
		redirectAttributes.addFlashAttribute("contactForm", form);
		System.out.println("confirmView直前です");
		return "confirmView";
		
	}
	
	
}
