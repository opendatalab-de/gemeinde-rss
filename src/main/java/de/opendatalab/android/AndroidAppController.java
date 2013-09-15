package de.opendatalab.android;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.opendatalab.gemeinde.rss.data.AppAndroid;
import de.opendatalab.gemeinde.rss.data.AppAndroidRepository;
import de.opendatalab.utils.DateUtils;

@Controller
public class AndroidAppController {

	@Autowired
	private AppAndroidRepository appAndroidRepository;
	@Autowired
	private AppFeedView feedView;

	@RequestMapping(value = "appAndroid/rss", method = RequestMethod.GET)
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView(feedView);
		Date lastMonth = DateUtils.createLastMonth();
		Sort sort = new Sort(new Order(Direction.DESC, "pubDate"));
		List<AppAndroid> allItems = appAndroidRepository.findByPubDateGreaterThan(lastMonth, sort);
		mav.addObject("items", allItems);
		return mav;
	}
}
