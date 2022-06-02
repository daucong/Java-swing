/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.service;

/**
 *
 * @author Admin
 */

import java.util.List;
import thi_hk.Donhanghoa;
import thi_hk.Hoadon;

public interface ThongKeService {
    
    public List<Hoadon> getListHoadon();
    
    public List<Donhanghoa> getListDonhanghoa();
    
}