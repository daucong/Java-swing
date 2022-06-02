/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import thi_hk.Hoadon;
import thi_hk.service.ThongKeService;
import thi_hk.service.ThongKeServiceImpl;
import thi_hk.Donhanghoa;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
/**
 *
 * @author Admin
 */
public class QuanLyThongKeController {
    private ThongKeService thongKeService = null;

    public QuanLyThongKeController() {
        thongKeService = new ThongKeServiceImpl();
    }

    public void setDataToChart1(JPanel jpnItem) {
        List<Hoadon> listItem = thongKeService.getListHoadon();
        if (listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (Hoadon item : listItem) {
                dataset.addValue(item.getSoluong(), "Hàng hóa",item.getNgaylay_hd());
            }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng hàng hóa nhập".toUpperCase(),
                "Thời gian", "Số lượng",
                dataset, PlotOrientation.VERTICAL, true, true, true);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
        }
    }

    public void setDataToChart2(JPanel jpnItem) {
        List<Donhanghoa> listItem = thongKeService.getListDonhanghoa();

        TaskSeriesCollection ds = new TaskSeriesCollection();
        JFreeChart ganttChart = ChartFactory.createGanttChart(
                "BIỂU ĐỒ THEO DÕI TÌNH TRẠNG HÀNG HÓA",
                "HÀNG HÓA", "Thời gian", ds, true, true, true
        );

        TaskSeries taskSeries;
        Task task;

        if (listItem != null) {
            for (Donhanghoa item : listItem) {
                taskSeries = new TaskSeries(item.getTenSP());
                task = new Task(item.getTenSP(), new SimpleTimePeriod(item.getNgap_dathang(), item.getNgay_ketThuc()));
                taskSeries.add(task);
                ds.add(taskSeries);
            }
        }

        ChartPanel chartPanel = new ChartPanel(ganttChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}
