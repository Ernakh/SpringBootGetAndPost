package AtosUFN.projeto1.Controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AtosUFN.projeto1.Models.PessoaModel;

@Controller
public class PessoaController 
{
	@RequestMapping("/pessoas")
	public ModelAndView listar()
	{
		Random rand = new Random();
		  ArrayList<AtosUFN.projeto1.Models.PessoaModel> lista = new ArrayList<>();
		  
		 for (int i = 0; i < 10; i++) 
		 {
			 lista.add(new PessoaModel("pessoa " + rand.nextInt(), rand.nextInt(80)));
		 }
		  
		 for (Iterator<PessoaModel> iterator = lista.iterator(); iterator.hasNext();) 
		 {
			PessoaModel pessoaModel = (PessoaModel) iterator.next();
			System.out.println(pessoaModel.toString());
		 }
	     
	    ModelAndView modelAndView = new ModelAndView("pessoas");
	    modelAndView.addObject("pessoas", lista);
	     
	    return modelAndView;
	}
	
	@GetMapping("/formulario")
	public String enviarForm(PessoaModel pessoa)
	{
		System.out.println(pessoa.toString());
		
		return "formulario";
	}
	
	@PostMapping("/formulario")
	public String processarForm(PessoaModel pessoa)
	{
		System.out.println(pessoa.toString());
		
		//código do banco
		
		return "resultado";
	}
}
