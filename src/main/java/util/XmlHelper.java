package util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.puhov.entity.MenuItem;

@XmlType
@XmlRootElement
public class XmlHelper {

	private List<MenuItem> menu;

	public List<MenuItem> getMenu() {
	return menu;
	}

	public void setMenu(List<MenuItem> menu) {
	this.menu = menu;
	}
}
