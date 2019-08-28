# 디렉토리 구조
## npm install tree-extended -g
## tree-extended -max=10 -max-show-not-empty

├───src/
│   └───main/
│       ├───java/
│       │   ├───app/
│       │   │   ├───controller/
│       │   │   │   ├───auth/
│       │   │   │   │   └───AuthController.java
│       │   │   │   ├───bbs/
│       │   │   │   │   └───bbsController.java
│       │   │   │   ├───comment/
│       │   │   │   │   └───CommentController.java
│       │   │   │   └───user/
│       │   │   │       └───UserController.java
│       │   │   ├───model/
│       │   │   │   ├───bbs/
│       │   │   │   │   └───BbsModel.java
│       │   │   │   ├───comment/
│       │   │   │   │   ├───CommentModel.java
│       │   │   │   │   └───CommentPage.java
│       │   │   │   └───user/
│       │   │   │       └───UserModel.java
│       │   │   ├───repository/
│       │   │   │   ├───bbs/
│       │   │   │   │   └───BbsRepo.java
│       │   │   │   ├───comment/
│       │   │   │   │   └───CommentRepo.java
│       │   │   │   └───user/
│       │   │   │       └───UserRepo.java
│       │   │   ├───service/
│       │   │   │   ├───impl/
│       │   │   │   │   ├───BbsServiceimpl.java
│       │   │   │   │   ├───CommentServiceimpl.java
│       │   │   │   │   └───UserServiceimpl.java
│       │   │   │   ├───BbsService.java
│       │   │   │   ├───CommentService.java
│       │   │   │   └───UserService.java
│       │   │   └───App.java
│       │   └───config/
│       │       ├───Message.java
│       │       └───Url.java
│       └───resources/
│           └───application.yml
├───.classpath
├───mvnw
├───mvnw.cmd
├───package-lock.json
└───pom.xml