
import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.dao.GerenteDao;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ideiah Computer
 */
public class LimpaBanco {
    
    public static void main(String args[]){
        ProjetoDao proj = new ProjetoDao();
        List<Projeto> objetos = proj.buscar();
        System.out.println("Apagando");
        for (Projeto objeto : objetos) {
            System.out.println("Apagando");
            proj.deletar(objeto.getIdProjeto());
        }
        EmpreendedorDao empre = new EmpreendedorDao();
        List<Empreendedor> objetosempre = empre.buscar();
        System.out.println("Apagando");
        for (Empreendedor empreendedor : objetosempre) {
            System.out.println("Apagando");
            empre.deletar(empreendedor.getIdUsuario());
        }
         GerenteDao gerente = new GerenteDao();
        List<GerenteRelacionamento> gerentes = gerente.buscarTodosGerente();
        System.out.println("Apagando");
        for (GerenteRelacionamento ger : gerentes) {
            System.out.println("Apagando");
            empre.deletar(ger.getIdgerente_relacionamento());
        }   
    
}
}
