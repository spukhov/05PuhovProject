package com.puhov.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.XmlHelper;

import com.puhov.entity.MenuItem;
import com.puhov.service.MenuItemService;

@Component
@ManagedBean
@RequestScoped
public class XmlBean {

	private String xml;
	@Autowired
	private MenuItemService menuItemService;

	public String getXml() {
		try {
			List<MenuItem> menu = menuItemService.findAll();
			XmlHelper xml = new XmlHelper();
			xml.setMenu(menu);
			String path = new File("").getAbsolutePath();
			path += "\\src\\main\\webapp\\resources\\xml\\menu.xml";
			JAXBContext jc = JAXBContext.newInstance(XmlHelper.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			OutputStream os = new FileOutputStream(path);
			m.marshal(xml, os);
			os.close();
		} catch (Exception ex) {
		}
		return "http://localhost:8080/05PuhovProject/resources/xml/menu.xml";
	}

}