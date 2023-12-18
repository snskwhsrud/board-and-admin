package com.example.boardadmin.service;

<<<<<<< HEAD
=======
import com.example.boardadmin.domain.constant.RoleType;
>>>>>>> afe78be51f842943efb30446e0adf2625baf151f
import com.example.boardadmin.dto.ArticleDto;
import com.example.boardadmin.dto.UserAccountDto;
import com.example.boardadmin.dto.properties.ProjectProperties;
import com.example.boardadmin.dto.response.ArticleClientResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;

import java.time.LocalDateTime;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Set;
>>>>>>> afe78be51f842943efb30446e0adf2625baf151f

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ActiveProfiles("test")
@DisplayName("비즈니스 로직 - 게시글 관리")
class ArticleManagementServiceTest {

<<<<<<< HEAD
    @Disabled("실제 API 호출 결과 관찰용이므로 평상시엔 비활성화")
=======
    //    @Disabled("실제 API 호출 결과 관찰용이므로 평상시엔 비활성화")
>>>>>>> afe78be51f842943efb30446e0adf2625baf151f
    @DisplayName("실제 API 호출 테스트")
    @SpringBootTest
    @Nested
    class RealApiTest {

<<<<<<< HEAD
    private final ArticleManagementService sut;

    @Autowired
    public RealApiTest(ArticleManagementService sut) {
        this.sut = sut;
    }

    @DisplayName("게시글 API를 호출하면, 게시글을 가져온다.")
    @Test
    void givenNothing_whenCallingArticleApi_thenReturnsArticleList() {
        // Given

        // When
        List<ArticleDto> result = sut.getArticles();

        // Then
        System.out.println(result.stream().findFirst());
        assertThat(result).isNotNull();
    }
}

=======
        private final ArticleManagementService sut;

        @Autowired
        public RealApiTest(ArticleManagementService sut) {
            this.sut = sut;
        }

        @DisplayName("게시글 API를 호출하면, 게시글을 가져온다.")
        @Test
        void given_when_then() {
            // Given

            // When
            List<ArticleDto> result = sut.getArticles();

            // Then
            System.out.println(result.stream().findFirst());
            assertThat(result).isNotNull();
        }
    }

>>>>>>> afe78be51f842943efb30446e0adf2625baf151f
    @DisplayName("API mocking 테스트")
    @EnableConfigurationProperties(ProjectProperties.class)
    @AutoConfigureWebClient(registerRestTemplate = true)
    @RestClientTest(ArticleManagementService.class)
    @Nested
    class RestTemplateTest {

        private final ArticleManagementService sut;

        private final ProjectProperties projectProperties;
        private final MockRestServiceServer server;
        private final ObjectMapper mapper;

        @Autowired
        public RestTemplateTest(
                ArticleManagementService sut,
                ProjectProperties projectProperties,
                MockRestServiceServer server,
                ObjectMapper mapper
        ) {
            this.sut = sut;
            this.projectProperties = projectProperties;
            this.server = server;
            this.mapper = mapper;
        }

        @DisplayName("게시글 목록 API를 호출하면, 게시글들을 가져온다.")
        @Test
        void givenNothing_whenCallingArticlesApi_thenReturnsArticleList() throws Exception {
            // Given
            ArticleDto expectedArticle = createArticleDto("제목", "글");
            ArticleClientResponse expectedResponse = ArticleClientResponse.of(List.of(expectedArticle));
            server
                    .expect(requestTo(projectProperties.board().url() + "/api/articles?size=10000"))
                    .andRespond(withSuccess(
                            mapper.writeValueAsString(expectedResponse),
                            MediaType.APPLICATION_JSON
                    ));

            // When
            List<ArticleDto> result = sut.getArticles();

            // Then
            assertThat(result).first()
                    .hasFieldOrPropertyWithValue("id", expectedArticle.id())
                    .hasFieldOrPropertyWithValue("title", expectedArticle.title())
                    .hasFieldOrPropertyWithValue("content", expectedArticle.content())
                    .hasFieldOrPropertyWithValue("userAccount.nickname", expectedArticle.userAccount().nickname());
            server.verify();
        }

        @DisplayName("게시글 ID와 함께 게시글 API을 호출하면, 게시글을 가져온다.")
        @Test
        void givenArticleId_whenCallingArticleApi_thenReturnsArticle() throws Exception {
            // Given
            Long articleId = 1L;
            ArticleDto expectedArticle = createArticleDto("게시판", "글");
            server
<<<<<<< HEAD
                    .expect(requestTo(projectProperties.board().url() + "/api/articles/" + articleId + "?projection=withUserAccount"))
=======
                    .expect(requestTo(projectProperties.board().url() + "/api/articles/" + articleId))
>>>>>>> afe78be51f842943efb30446e0adf2625baf151f
                    .andRespond(withSuccess(
                            mapper.writeValueAsString(expectedArticle),
                            MediaType.APPLICATION_JSON
                    ));

            // When
            ArticleDto result = sut.getArticle(articleId);

            // Then
            assertThat(result)
                    .hasFieldOrPropertyWithValue("id", expectedArticle.id())
                    .hasFieldOrPropertyWithValue("title", expectedArticle.title())
                    .hasFieldOrPropertyWithValue("content", expectedArticle.content())
                    .hasFieldOrPropertyWithValue("userAccount.nickname", expectedArticle.userAccount().nickname());
            server.verify();
        }

        @DisplayName("게시글 ID와 함께 게시글 삭제 API을 호출하면, 게시글을 삭제한다.")
        @Test
        void givenArticleId_whenCallingDeleteArticleApi_thenDeletesArticle() throws Exception {
            // Given
            Long articleId = 1L;
            server
                    .expect(requestTo(projectProperties.board().url() + "/api/articles/" + articleId))
                    .andExpect(method(HttpMethod.DELETE))
                    .andRespond(withSuccess());

            // When
            sut.deleteArticle(articleId);

            // Then
            server.verify();
        }


        private ArticleDto createArticleDto(String title, String content) {
            return ArticleDto.of(
                    1L,
                    createUserAccountDto(),
                    title,
                    content,
                    null,
                    LocalDateTime.now(),
                    "Uno",
                    LocalDateTime.now(),
                    "Uno"
            );
        }

        private UserAccountDto createUserAccountDto() {
            return UserAccountDto.of(
                    "unoTest",
<<<<<<< HEAD
=======
                    "pw",
                    Set.of(RoleType.ADMIN),
>>>>>>> afe78be51f842943efb30446e0adf2625baf151f
                    "uno-test@email.com",
                    "uno-test",
                    "test memo"
            );
        }
    }

}