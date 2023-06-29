<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang='ko'>
    <head>
        <meta charset='UTF-8'>
        <title>Document</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <form action="/url/originURL" method="GET">
                <div class="mb-3">
                    <label for="originalURL" class="form-lable">단축 시킬 주소</label>
                    <input type="text" class="form-control" name="originURL" id="origin" placeholder="Paste a link to shorten it">
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary mb-3">챱챱</button>
                </div>
            </form>
            <div class="col-auto">
                <label for="shortURL" class="form-lable">단축된 주소</label>
                <input class="form-control" name="shortURL" id="shortURL" value="${shortURL}" readonly>
            </div>
        </div>
    </body>
</html>