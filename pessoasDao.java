/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.veiculo.entity.Pessoas;
import br.com.veiculo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author Ricardo
 * Observações: Toda operação de listagem , remoção, inclusão no banco é feita na classe Dao
 */
public class pessoasDao { // Classe que faz a comunicação com o banco
    private Session sessao;
    private Transaction trans;
    private List<Pessoas> list; 

    
    public List<Pessoas> getList() { // metodo que retorna a lista
        sessao = HibernateUtil.getSessionFactory().openSession(); // abre a sessão
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Pessoas.class); // pesquisar criteria
        this.list = cri.list(); 
        return list;
    }
    
   
    public void addPessoa(Pessoas p) { // adicionar pessoas no hibernat
        try{    
        sessao = HibernateUtil.getSessionFactory().openSession(); // abre a sessão
        trans = sessao.beginTransaction();
        // pegando os atributos da classe pessoa
        Pessoas pessoa = new Pessoas ();
       
        pessoa.setNome (p.getNome());
        pessoa.setTelefone(p.getTelefone());
        pessoa.setEmail (p.getEmail());
        
        
        sessao.save(pessoa); // comomando para salvar no hibernat
        trans.commit(); // confirmação da gravação, grava no banco de dados
        
        } catch (Exception e){
            e.printStackTrace();
        
        } finally{
            sessao.close();
        } 
    
    }  
    
    public void removePessoa (Pessoas p){
         try{    
        sessao = HibernateUtil.getSessionFactory().openSession(); // abre a sessão
        trans = sessao.beginTransaction();
        // pegando os atributos da classe pessoa
        
        
        sessao.delete(p); // deletar o objeto no banco de dados
        trans.commit(); //  grava no banco de dados
        
        } catch (Exception e){
            e.printStackTrace();
        
        } finally{
     sessao.close();
        } 
    }

    

    
}
