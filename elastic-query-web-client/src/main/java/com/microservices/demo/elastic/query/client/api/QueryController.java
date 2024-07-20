package com.microservices.demo.elastic.query.client.api;

import com.microservices.demo.elastic.query.client.model.ElasticQueryWebClientRequestModel;
import com.microservices.demo.elastic.query.client.model.ElasticQueryWebClientResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QueryController {

    private static final Logger LOG = LoggerFactory.getLogger(QueryController.class);

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("ElasticQueryWebClientRequestModel",
                ElasticQueryWebClientRequestModel.builder().build());
        return "home";
    }

    @PostMapping("/query-by-text")
    public String queryByText(@Valid ElasticQueryWebClientRequestModel elasticQueryWebClientRequestModel,
                              Model model) {
        LOG.info("Querying with text: {}", elasticQueryWebClientRequestModel.getText());
        List<ElasticQueryWebClientResponseModel> responseModels = new ArrayList<>();
        responseModels.add(ElasticQueryWebClientResponseModel.builder()
                .id("1")
                .text(elasticQueryWebClientRequestModel.getText())
                .build());
        model.addAttribute("ElasticQueryWebClientRequestModel", responseModels);
        model.addAttribute("searchText", elasticQueryWebClientRequestModel.getText());
        model.addAttribute("ElasticQueryWebClientRequestModel",
                ElasticQueryWebClientRequestModel.builder().build());
        return "home";
    }

}
