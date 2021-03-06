package br.com.aluras.listavip;

import br.com.aluras.listavip.model.Convidado;
import br.com.aluras.listavip.service.ConvidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadeService convidadeService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("listaconvidados")
    public String listaConvidados(Model model) {

        Iterable<Convidado> convidados = convidadeService.obterTodos();
        model.addAttribute("convidados", convidados);
        return "listaconvidados";
    }

    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("telefone") String telefone, Model model) {
        Convidado convidado = new Convidado(nome, email, telefone);
        convidadeService.salvar(convidado);
//        new br.com.alura.enviadorEmail.enviadorEmail.EmailService().enviar(nome, email);

        Iterable<Convidado> convidados = convidadeService.obterTodos();
        model.addAttribute("convidados", convidados);
        return "listaconvidados";
    }

}
