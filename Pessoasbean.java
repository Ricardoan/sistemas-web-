/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.bean;

import br.com.veiculo.entity.Pessoas;
import br.com.veiculo.entity.Paciente;
import br.com.veiculo.dao.pessoasDao;
import br.com.veiculo.dao.pacienteDao;
import java.util.List;
import javax.faces.bean.*;


/**
 *
 * @author Ricardo
 */
@ManagedBean
@SessionScoped
public class Pessoasbean {

    /**
     * Creates a new instance of Pessoasbean
     */
    private Pessoas pessoa = new Pessoas ();
    private pessoasDao pessoaDao = new pessoasDao();
    private List<Pessoas>  listarPessoas;
    
    
    public Pessoasbean() {
    }

    public Pessoas getPessoa() {
        return pessoa;
    }
    //**************************************
    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }
    
    //**************************************
   public List listarPessoas(){
      listarPessoas = pessoaDao.getList();
       return this.listarPessoas;
   }
   
   //************************************** 
    public String adicionarPessoa (){  // adicionar pessoas
        pessoaDao.addPessoa (pessoa);
        
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setTelefone(null);
        return "index";
    }
    
  
    //*************************************
    public String removerPessoa (Pessoas p){
        this.pessoa = p;
        pessoaDao.removePessoa (pessoa);
        this.pessoa.setNome(null); // excluir o nome da pessoa na pagina html 
        this.pessoa.setEmail(null);
        this.pessoa.setTelefone(null);
        return "index";
    }
    
    //***************************************
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.pessoa != null ? this.pessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoasbean other = (Pessoasbean) obj;
        if (this.pessoa != other.pessoa && (this.pessoa == null || !this.pessoa.equals(other.pessoa))) {
            return false;
        }
        return true;
    }
    
    
}
