package org.sopt.play.domain.model

data class PostModel(
    val postId: Long,
    val title: String,
    val content: String,
    val author: String,
    val createdAt: Long,
    val updatedAt: Long,
)

val postDummy = listOf(
    PostModel(
        postId = 1L,
        title = "글쓰기 테스트입니다 하하하하",
        content = "본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다.",
        author = "응아니야",
        createdAt = 1792796400000L,
        updatedAt = 1792796400000L,
    ),
    PostModel(
        postId = 2L,
        title = "웹토리들아",
        content = "세미나 열심히 듣고 있나요? 파이띵!ㅋㅋ",
        author = "민나",
        createdAt = 1792364400000L,
        updatedAt = 1792364400000L,
    ),
    PostModel(
        postId = 3L,
        title = "안드들아",
        content = "지각하면 가만안드 👊",
        author = "힘멜도연",
        createdAt = 1791241200000L,
        updatedAt = 1791241200000L,
    ),
    PostModel(
        postId = 4L,
        title = "모아요들아",
        content = "사과 잊지 말고 항상 가지고 다녀라",
        author = "상엽",
        createdAt = 1791241200000L,
        updatedAt = 1791241200000L,
    ),
    PostModel(
        postId = 5L,
        title = "글쓰기 테스트입니다 하하하하",
        content = "본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다.",
        author = "응아니야",
        createdAt = 1792796400000L,
        updatedAt = 1792796400000L,
    ),
    PostModel(
        postId = 6L,
        title = "웹토리들아",
        content = "세미나 열심히 듣고 있나요? 파이띵!ㅋㅋ",
        author = "민나",
        createdAt = 1792364400000L,
        updatedAt = 1792364400000L,
    ),
    PostModel(
        postId = 7L,
        title = "안드들아",
        content = "지각하면 가만안드 👊",
        author = "힘멜도연",
        createdAt = 1791241200000L,
        updatedAt = 1791241200000L,
    ),
    PostModel(
        postId = 8L,
        title = "모아요들아",
        content = "사과 잊지 말고 항상 가지고 다녀라",
        author = "상엽",
        createdAt = 1791241200000L,
        updatedAt = 1791241200000L,
    ),
)
