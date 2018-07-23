//package com.example.WebTask;
//
//import com.example.WebTask.modules.user.LoginUser;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jayway.jsonpath.JsonPath;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
//
//@SpringBootTest(
//        classes = WebTaskApplication.class)
//@RunWith(SpringRunner.class)
//@Ignore
//public class AbstractMvcTest {
//    protected MockMvc mockMvc;
//    private ObjectMapper mapper = new ObjectMapper();
//    private static Set<Class> inited = new HashSet<>();
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Before
//    public void setup() {
//        mockMvc = webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
//    }
//
//    @Before
//    public void init() throws Exception {
//        if (!inited.contains(getClass())) {
//            doInit();
//            inited.add(getClass());
//        }
//    }
//
//    protected void doInit() throws Exception {
//    }
//
//    protected String json(Object o) throws IOException {
//        return mapper.writeValueAsString(o);
//    }
//
//    protected ResultActions login(String username, String password) throws Exception {
//        final LoginUser auth = new LoginUser();
//        auth.setUsername(username);
//        auth.setPassword(password);
//        return mockMvc.perform(
//                post("http://localhost:8080/WebTask/token/generate-token")
//                        .content(json(auth))
//                        .contentType(MediaType.APPLICATION_JSON));
//    }
//
//    protected String extractToken(MvcResult result) throws UnsupportedEncodingException {
//        return JsonPath.read(result.getResponse().getContentAsString(), "$.token");
//    }
//
//}