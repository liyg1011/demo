package com.demo;

/**
 * 图像压缩工具
 * TODO：该类需要重做
 */
public class FileUtil {

//    /**
//     * 上传图片
//     *
//     * @param file     要上传的文件
//     * @param filePath 文件路径
//     * @param fileName 文件名称
//     */
//    public static void uploadFile(File file, String filePath, String fileName) {
//        try {
//            Preconditions.checkNotNull(file);
//            Preconditions.checkNotNull(filePath);
//            Preconditions.checkNotNull(fileName);
//
////            创建文件夹
//            File localPath = new File(filePath);
//            if (!localPath.exists()) {
//                localPath.mkdirs();
//            }
//
////            将文件保存到本地
//            org.apache.commons.io.FileUtil.copyFile(file, new File(filePath, fileName));
//        } catch (Exception e) {
//            throw new RuntimeException("图片上传失败");
//        }
//    }
//
//    public static String uploadFile(MultipartFile companyLogoFile, String filePath) {
//        String fileName = companyLogoFile.getOriginalFilename();
//        String extensionName = fileName.substring(fileName.lastIndexOf("."));
//        String fileNewName = DateTimeUtil.nowDateTime2() + StringUtil.randomNumber(4);
//        File saveFile = new File(ConfigUtil.getFilePath() + filePath + fileNewName + extensionName);
//        if (!saveFile.exists()) {
//            saveFile.mkdirs();
//        }
//        try {
//            companyLogoFile.transferTo(saveFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }
//        return filePath + fileNewName + extensionName;
//    }
//
//    public static String buildQRCode(String url) {
//        try {
//            int width = 400;          // 图像宽度
//            int height = 400;         // 图像高度
//            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height);// 生成矩阵
//
//            String filePath = "/image/qr/" + DateTimeUtil.nowDateTime1();
//            String fileName = StringUtil.randomNumber(8) + ".png";
//            File file = new File(ConfigUtil.getFilePath() + filePath + "/" + fileName);
//            if (!file.exists()) {
//                file.mkdirs();
//            }
//
//            String format = "png";    // 图像类型
//            Path path = file.toPath();
//            MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
//
//            return filePath + "/" + fileName;
//        } catch (WriterException | IOException e) {
//            e.printStackTrace();
//            return "";
//        }
//
//    }
//
//    public static void main(String[] args) {
//        FileUtil.buildQRCode("http://www.baidu.com");
//    }

}
