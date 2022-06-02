package thi_hk;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Chuyenmau {
    private JPanel Root ;
    private String kindSelected ="";
    private List<DM_mau> listItem = null;
    
    public Chuyenmau(JPanel jpnRoot){
        this.Root = jpnRoot;
    }

    public void setView(JPanel jpnDMsp, JLabel jlbDMsp) throws SQLException {
        kindSelected = "DM_sanpham";
        jpnDMsp.setBackground(new Color(96,100,191));
        jlbDMsp.setBackground(new Color(96,100,191));
        Root.removeAll();
        Root.setLayout(new BorderLayout());
        Root.add(new DM_spJPanel());
        Root.validate();
        Root.repaint();
    }

     
    public void setEvent(List<DM_mau> listItem){
        this.listItem = listItem;
       for(DM_mau item : listItem){
           item.getJlb().addMouseListener(new lableEvent(item.getKind(), item.getJpn(), item.getJlb()));
       }
   }

   class lableEvent implements MouseListener{
        private JPanel node ;
        private  String kind ;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public lableEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                switch(kind){
                    case "DM_sanpham" :
                        node = new DM_spJPanel();
                        break;             
                    case "Quanly_sp" :
                        node = new QL_spJPanel();
                        break;
                    case "Donhang" :
                        node = new DonhangPanel();
                        break;
                    case "Thongke_sp" :
                        node = new Thongke_spJPanel();
                        break;
                    case "Quanly_kh" :
                        node = new Quanly_khJPanel();
                        break;
                    default:
                        node = new DM_spJPanel();
                        break;
                        
                        
                }
                Root.removeAll();
                Root.setLayout(new BorderLayout());
                Root.add(node);
                Root.validate();
                Root.repaint();
                setChangeBackground(kind);
            } catch (SQLException ex) {
                Logger.getLogger(Chuyenmau.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(76,175,80));
                jlbItem.setBackground(new Color(76,175,80));
            }
        }
       
   }
   public void setChangeBackground(String kind){
       for(DM_mau item : listItem){
           if(item.getKind().equalsIgnoreCase(kind)){
               item.getJpn().setBackground(new Color(96,100,191));
               item.getJlb().setBackground(new Color(96,100,191));
               
           }else{
               item.getJpn().setBackground(new Color(76,175,80));
               item.getJlb().setBackground(new Color(76,175,80));
           }
       }
   }

}
