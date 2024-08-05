package com.xzit.demo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author leizefeng
 */
@SpringBootTest
public class JsonNodeTest {

    @Test
    public void testJsonNode() throws JsonProcessingException {
        String jsonString = "{\n"
                + "  \"id\":\"09194567\",\n"
                + "  \"studentName\":\"王三\",\n"
                + "  \"nickName\": null,\n"
                + "  \"englishName\":\"King Three\",\n"
                + "  \"age\":32,\n"
                + "  \"email\":\"123@qq.com\",\n"
                + "  \"birthday\":\"1989-12-21\",\n"
                + "  \"joinDate\":\"2019-03-10 11:15:39\",\n"
                + "  \"courseScores\":[\n"
                + "    {\n"
                + "      \"course\":\"Java\",\n"
                + "      \"score\":95\n"
                + "    },\n"
                + "    {\n"
                + "      \"course\":\"C#\",\n"
                + "      \"score\":94\n"
                + "    },\n"
                + "    {\n"
                + "      \"course\":\"C++\",\n"
                + "      \"score\":89\n"
                + "    }\n"
                + "  ],\n"
                + "  \"courseScoresGroup\":{\n"
                + "    \"A\":[\n"
                + "      \"Java\",\n"
                + "      \"C#\"\n"
                + "    ],\n"
                + "    \"B\":[\n"
                + "      \"C++\"\n"
                + "    ]\n"
                + "  },\n"
                + "  \"valid\":true\n"
                + "}\n";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);
//        String string = objectMapper.writeValueAsString(jsonNode);
//        System.out.println(jsonNode);
//        System.out.println(string);
//        System.out.println(jsonNode.get("studentName"));
//        System.out.println(jsonNode.get("nickName"));

        System.out.println("=================================");
        List<String> blockList = new ArrayList<>();
        Collections.addAll(blockList, "age", "email", "score");
        for (String s : blockList) {
            List<JsonNode> parents = jsonNode.findParents(s);
            for (JsonNode parent : parents) {
                ((ObjectNode) parent).put(s, "******");
            }
        }
        String string = objectMapper.writeValueAsString(jsonNode);
        System.out.println(string);
    }

    @Test
    public void testObjectNode() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode studentNode = mapper.createObjectNode();
        studentNode.put("id", "1");
        studentNode.put("name", "亚瑟");
        studentNode.put("age", 30);
        System.out.println(studentNode);
        studentNode.remove("age");
        System.out.println(studentNode);
        System.out.println(mapper.writeValueAsString(studentNode));
    }
}
