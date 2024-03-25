package utez.edu.mx.IntegradoraPodec.Config;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileService {



    public MultipartFile createMultipartFileFromBytes(byte[] fileBytes, String filename) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(fileBytes);
        return new CustomMultipartFile(inputStream, filename);
    }

    private static class CustomMultipartFile implements MultipartFile {

        private final InputStream inputStream;
        private final String filename;

        public CustomMultipartFile(InputStream inputStream, String filename) {
            this.inputStream = inputStream;
            this.filename = filename;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getOriginalFilename() {
            return filename;
        }

        @Override
        public String getContentType() {
            // Puedes proporcionar un tipo MIME adecuado según el tipo de archivo si lo deseas
            return "application/octet-stream";
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public long getSize() {
            try {
                return inputStream.available();
            } catch (IOException e) {
                return 0;
            }
        }

        @Override
        public byte[] getBytes() throws IOException {
            return StreamUtils.copyToByteArray(inputStream);
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return inputStream;
        }

        @Override
        public void transferTo(java.io.File file) throws IOException, IllegalStateException {
            // Puedes implementar esta función si necesitas guardar el archivo en el servidor
        }
    }
        }


