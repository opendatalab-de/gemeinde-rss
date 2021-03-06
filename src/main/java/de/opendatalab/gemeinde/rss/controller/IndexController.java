package de.opendatalab.gemeinde.rss.controller;

import static org.springframework.util.StringUtils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.opendatalab.gemeinde.rss.RssFeedService;

@Controller
public class IndexController {

	@Autowired
	private RssFeedService rssFeedService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView get(String gemeinde) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("items", rssFeedService.getItems(gemeinde));
		if (hasText(gemeinde))
			mav.addObject("gemeinde", gemeinde);
		return mav;
	}
}
