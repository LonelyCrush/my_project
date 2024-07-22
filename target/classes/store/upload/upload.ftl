<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>文件上传</title>
    <script type="text/javascript" src="http://localhost:8081/fileServer/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="http://localhost:8081/fileServer/js/ajaxfileupload.js"></script>
    <style>

    </style>
</head>
<body>
<script>
    function upload() {
        var requestUrl= "http://localhost:8081/fileServer/fileUpload/uploadToServer";
        $.ajaxFileUpload({
            url:requestUrl,
            secureuri:true,  //是否启用安全提交
            dataType: 'text',   //数据类型
            fileElementId:'uploadFile', //表示文件域ID
            success: function(data,status){
                alert(status);
                alert(data);
            },
            //提交失败处理函数
            error: function (data,status,e){
                alert(status);
            }
        });
    }
</script>
<div>
    <input type="file" name="uploadFile" id="uploadFile"/>
    <button type="submit" value="" onclick="upload();">上传文件</button>
</div>

</body>
</html>
