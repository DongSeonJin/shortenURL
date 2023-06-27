<!DOCTYPE html>
<html lang='ko'>
    <head>
        <meta charset='UTF-8'>
        <title>Document</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <form action="/url" method="GET">
                <div class="mb-3">
                    <label for="originalURL" class="form-lable">단축 시킬 주소</label>
                    <input type="text" class="form-control" name="origin" id="origin" placeholder="Paste a link to shorten it">
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary mb-3">Shorten it</button>
                  </div>
            </form>
        </div>
    </body>
</html>