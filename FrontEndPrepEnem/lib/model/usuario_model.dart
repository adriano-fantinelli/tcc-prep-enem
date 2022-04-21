import 'dart:convert';

UsuarioModel usuarioModelFromJson(String str) =>
    UsuarioModel.fromJson(json.decode(str));

String usuarioModelToJson(UsuarioModel data) => json.encode(data.toJson());

class UsuarioModel {
  UsuarioModel({
    this.id,
    this.email,
    this.senha,
    this.nome,
    this.descricao,
    this.numeroCelular,
    this.professor,
    this.desempenho,
    this.explicacao,
  });

  int? id;
  String? email;
  String? senha;
  String? nome;
  String? descricao;
  String? numeroCelular;
  bool? professor;
  dynamic desempenho;
  dynamic explicacao;

  factory UsuarioModel.fromJson(Map<String, dynamic> json) => UsuarioModel(
        id: json["id"],
        email: json["email"],
        senha: json["senha"],
        nome: json["nome"],
        descricao: json["descricao"],
        numeroCelular: json["numeroCelular"],
        professor: json["professor"],
        desempenho: json["desempenho"],
        explicacao: json["explicacao"],
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "email": email,
        "senha": senha,
        "nome": nome,
        "descricao": descricao,
        "numeroCelular": numeroCelular,
        "professor": professor,
        "desempenho": desempenho,
        "explicacao": explicacao,
      };
}
