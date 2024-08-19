# Diretórios
SRC_DIR="bankjava"           # Diretório onde estão os arquivos .java
CLASS_DIR="classes"     # Diretório onde os arquivos .class serão armazenados

# Criar diretório para os arquivos .class, se não existir
mkdir -p $CLASS_DIR

# Compilar os arquivos .java e guardar os .class em $CLASS_DIR
javac -d $CLASS_DIR Menu.java $SRC_DIR/*.java

# Navegar para o diretório onde os arquivos .class foram gerados
cd $CLASS_DIR

# Executar a classe principal
java Menu
