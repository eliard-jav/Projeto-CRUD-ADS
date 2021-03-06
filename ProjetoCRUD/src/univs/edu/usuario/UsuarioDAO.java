
package univs.edu.usuario;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import univs.edu.util.HibernateUtil;


public class UsuarioDAO {
    
    private Session sessao;
    private Transaction transacao;
    
    public void salvar(Usuario usuario){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        if(usuario.getIdUsuario() == 0){
        sessao.save(usuario);
            JOptionPane.showMessageDialog(null,"Usuário cadastrado");
        }else{
            sessao.update(usuario);
            JOptionPane.showMessageDialog(null,"Usuário Ediatado");
        }
        transacao.commit();
        sessao.close();
        
    }
    public void editarUsuario(Usuario usuario){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.update(usuario);
        transacao.commit();
        sessao.close();
    }
    
    
     public void excluir(Usuario usuario){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(usuario);
        transacao.commit();
        sessao.close();
        
    }
     
     public Usuario pesquisarUsuarioId(int id){
          sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("idUsuario",id)).uniqueResult();
        
        sessao.close();
        return usuario;
         
         
     }
     
     public List<Usuario> pesquisar(){
          sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        
        List<Usuario> usuarios = sessao.createCriteria(Usuario.class).list();
        
        return usuarios ;
         
         
     }

    public List<Usuario> listarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
