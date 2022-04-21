// ignore_for_file: prefer_const_constructors, prefer_const_literals_to_create_immutables, unused_local_variable

import 'package:flutter/material.dart';
import 'package:prepenem/model/usuario_model.dart';
import 'package:http/http.dart' as http;

class Perfil extends StatefulWidget {
  const Perfil({Key? key}) : super(key: key);

  @override
  State<Perfil> createState() => _PerfilState();
}

class _PerfilState extends State<Perfil> {
  // Future<UsuarioModel> getUsuario(String id){
  //   final String apiURL = "http://10.0.2.2:8080/usuarios/"+id;
  //   final Uri uri = Uri.parse(apiURL);
  //   return http.get(Uri,headers: headers)
  // }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              margin: EdgeInsets.fromLTRB(20, 50, 0, 0),
              child: Row(
                children: [
                  Text('Nome:',
                      textScaleFactor: 1,
                      style: TextStyle(
                        fontFamily: 'Montserrat',
                        fontSize: 20.0,
                        fontWeight: FontWeight.w700,
                        color: Color.fromARGB(255, 41, 43, 35),
                      )),
                  Padding(
                    padding: const EdgeInsets.only(left: 5),
                    child: Text('Pedro Henrique Roza',
                        textScaleFactor: 1,
                        style: TextStyle(
                          fontFamily: 'Montserrat',
                          fontSize: 20.0,
                          fontWeight: FontWeight.w700,
                          color: Color.fromARGB(255, 41, 43, 35),
                        )),
                  ),
                ],
              ),
            ),
            Container(
              margin: EdgeInsets.fromLTRB(20, 22, 0, 0),
              child: Row(
                children: [
                  Text('E-mail:',
                      textScaleFactor: 1,
                      style: TextStyle(
                        fontFamily: 'Montserrat',
                        fontSize: 20.0,
                        fontWeight: FontWeight.w700,
                        color: Color.fromARGB(255, 41, 43, 35),
                      )),
                  Padding(
                    padding: const EdgeInsets.only(left: 5),
                    child: Text('p@gmail.com',
                        textScaleFactor: 1,
                        style: TextStyle(
                          fontFamily: 'Montserrat',
                          fontSize: 20.0,
                          fontWeight: FontWeight.w700,
                          color: Color.fromARGB(255, 41, 43, 35),
                        )),
                  ),
                ],
              ),
            ),
            Container(
              margin: EdgeInsets.fromLTRB(20, 22, 0, 0),
              child: Row(
                children: [
                  Text('Telefone:',
                      textScaleFactor: 1,
                      style: TextStyle(
                        fontFamily: 'Montserrat',
                        fontSize: 20.0,
                        fontWeight: FontWeight.w700,
                        color: Color.fromARGB(255, 41, 43, 35),
                      )),
                  Padding(
                    padding: const EdgeInsets.only(left: 5),
                    child: Text('51998879372',
                        textScaleFactor: 1,
                        style: TextStyle(
                          fontFamily: 'Montserrat',
                          fontSize: 20.0,
                          fontWeight: FontWeight.w700,
                          color: Color.fromARGB(255, 41, 43, 35),
                        )),
                  ),
                ],
              ),
            ),
            Container(
              margin: EdgeInsets.fromLTRB(20, 50, 0, 0),
              child: Row(
                children: [
                  Text('Questões respondidas:',
                      textScaleFactor: 1,
                      style: TextStyle(
                        fontFamily: 'Montserrat',
                        fontSize: 20.0,
                        fontWeight: FontWeight.w700,
                        color: Color.fromARGB(255, 41, 43, 35),
                      )),
                  Padding(
                    padding: const EdgeInsets.only(left: 5),
                    child: Text('50',
                        textScaleFactor: 1,
                        style: TextStyle(
                          fontFamily: 'Montserrat',
                          fontSize: 20.0,
                          fontWeight: FontWeight.w700,
                          color: Color.fromARGB(255, 41, 43, 35),
                        )),
                  ),
                ],
              ),
            ),
            Container(
              margin: EdgeInsets.fromLTRB(20, 22, 0, 0),
              child: Row(
                children: [
                  Text('Média de acertos:',
                      textScaleFactor: 1,
                      style: TextStyle(
                        fontFamily: 'Montserrat',
                        fontSize: 20.0,
                        fontWeight: FontWeight.w700,
                        color: Color.fromARGB(255, 41, 43, 35),
                      )),
                  Padding(
                    padding: const EdgeInsets.only(left: 5),
                    child: Text('98%',
                        textScaleFactor: 1,
                        style: TextStyle(
                          fontFamily: 'Montserrat',
                          fontSize: 20.0,
                          fontWeight: FontWeight.w700,
                          color: Color.fromARGB(255, 41, 43, 35),
                        )),
                  ),
                ],
              ),
            ),
            Container(
              margin: EdgeInsets.fromLTRB(40, 70, 40, 0),
              child: Expanded(
                child: Text(
                    '    Tenho 18 anos, sou aluno do IFSUL - Campus Sapucaia do sul e curso o curso de informática',
                    textScaleFactor: 1,
                    style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 20.0,
                      fontWeight: FontWeight.w700,
                      color: Color.fromARGB(255, 41, 43, 35),
                    )),
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 30),
              child: SizedBox(
                width: 290,
                child: ElevatedButton(
                    onPressed: () {},
                    style: ButtonStyle(
                        backgroundColor: MaterialStateProperty.all<Color>(
                            Color(0xff40FD48))),
                    child: Text(
                      'Editar Perfil',
                      style: TextStyle(
                          fontFamily: 'Montserrat',
                          fontSize: 17.0,
                          fontWeight: FontWeight.w900,
                          color: Color.fromARGB(255, 62, 66, 55)),
                    )),
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 30),
              child: SizedBox(
                width: 290,
                child: ElevatedButton(
                    onPressed: () {},
                    style: ButtonStyle(
                        backgroundColor: MaterialStateProperty.all<Color>(
                            Color(0xff40FD48))),
                    child: Text(
                      'Excluir Perfil',
                      style: TextStyle(
                          fontFamily: 'Montserrat',
                          fontSize: 17.0,
                          fontWeight: FontWeight.w900,
                          color: Color.fromARGB(255, 62, 66, 55)),
                    )),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
