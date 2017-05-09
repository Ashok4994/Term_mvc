package com.controller;

import com.model.DirectoryBean;
import com.service.DirectoryService;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.service.FileService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
@MultipartConfig(maxFileSize = 16177215)
public class Upload extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        ArrayList<DirectoryBean> own_dir_list = new ArrayList<DirectoryBean>();
        ArrayList<DirectoryBean> m_dir_list = new ArrayList<DirectoryBean>();

        String title = request.getParameter("title");

        Integer dir_id = Integer.parseInt(request.getParameter("dir"));
        Part filePart = request.getPart("file_uploaded");
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("id");
        Integer mid = (Integer) session.getAttribute("manager_id");
        Random rand = new Random();
        int n = rand.nextInt(9999) + 1;
        InputStream inputStream = null;
        String type_file = null;
        if (filePart != null) {
            // out.println(filePart.getName());
            // out.println(filePart.getSize());
            type_file = filePart.getContentType();
            inputStream = filePart.getInputStream();
        }

        boolean status = false;
        try {
            own_dir_list = DirectoryService.getown(uid);
            m_dir_list = DirectoryService.getmanagers(mid);
            status = FileService.uploadFile(dir_id, filePart, title, uid, n);
        } catch (SQLException ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (status) {
            request.setAttribute("success","File uploaded successfully!");
            request.setAttribute("ownDirectoryList", own_dir_list);
            request.setAttribute("managers_dlist", m_dir_list);
            request.getRequestDispatcher("file_upload.jsp").forward(request, response);
        }

    }

}
