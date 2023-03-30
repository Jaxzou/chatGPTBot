package com.jax.ai;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.Test;

import java.io.IOException;

/***
 * @author Jax
 * @date 2023/3/20
 * @apiNote 测试类
 */
public class TestApi {

    @Test
    public void query_zsxq_questions() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        get.addHeader("cookie", "知识星球的个人cookie信息");
        get.addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
        get.addHeader("content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getCode() == HttpStatus.SC_SUCCESS) {
            //请求成功
            String resp = EntityUtils.toString(response.getEntity());
            System.out.println(resp);
        } else {
            System.out.println(response.getCode());
        }
    }

    /**
     * 非管理员没有回答全县哦，只能用下面的comments
     * @throws IOException
     */
    @Test
    public void answer() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412541554281158/answer");
        post.addHeader("cookie", "知识星球的个人cookie信息");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"测试完成！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getCode());
        }
    }

    /**
     * 知识星球的个人cookie信息
     * @throws IOException
     */
    @Test
    public void comments() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/214251288851211/comments");
        post.addHeader("cookie", "sensorsdata2015jssdkcross={\"distinct_id\":\"1866dd31fb2501-0820cc84e196ca8-16525635-1484784-1866dd31fb3ef1\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"引荐流量\",\"$latest_search_keyword\":\"未取到值\",\"$latest_referrer\":\"http://120.48.169.252/\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2NmRkMzFmYjI1MDEtMDgyMGNjODRlMTk2Y2E4LTE2NTI1NjM1LTE0ODQ3ODQtMTg2NmRkMzFmYjNlZjEifQ==\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"1866dd31fb2501-0820cc84e196ca8-16525635-1484784-1866dd31fb3ef1\"}; zsxqsessionid=d73aac8aca19c74dd18b4753d5609bd1; zsxq_access_token=313CB581-5332-AACF-84FB-7099E0D533A9_155C80056D356FFD; abtest_env=product");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"当然可以！ChatGPT是一种人工智能，可以回答各种各样的问题，包括高中和大学三门小三门的习题问题。不要害羞，放心地提出你的问题吧，ChatGPT会尽力回答你的问题。\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getCode());
        }
    }

    @Test
    public void test_chatGPT() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        //使用代理会稍微方便一点
        HttpPost post = new HttpPost("https://open.aiproxy.xyz/v1/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer sk-Yxxx");

        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"帮我写一个java冒泡排序\", \"temperature\": 0, \"max_tokens\": 1024}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getCode());
        }

    }
}
