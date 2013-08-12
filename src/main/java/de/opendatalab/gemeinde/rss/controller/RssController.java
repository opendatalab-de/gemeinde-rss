package de.opendatalab.gemeinde.rss.controller;

import static org.springframework.util.StringUtils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.opendatalab.gemeinde.rss.RssFeedService;
import de.opendatalab.gemeinde.rss.RssFeedView;

@Controller
@RequestMapping("rss")
public class RssController {

	@Autowired
	private RssFeedService rssFeedService;
	@Autowired
	private RssFeedView rssFeedView;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(String gemeinde) {
		ModelAndView mav = new ModelAndView(rssFeedView);
		mav.addObject("items", rssFeedService.getItems(gemeinde));
		if (hasText(gemeinde))
			mav.addObject("gemeinde", gemeinde);
		return mav;
	}
}
