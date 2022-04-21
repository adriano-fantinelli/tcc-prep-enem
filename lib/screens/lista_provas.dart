// ignore_for_file: prefer_const_constructors

import 'package:flutter/material.dart';

class ListaProvas extends StatefulWidget {
  const ListaProvas({Key? key}) : super(key: key);

  @override
  State<ListaProvas> createState() => _ListaProvasState();
}

class _ListaProvasState extends State<ListaProvas> {
  final ano = [
    '2022',
    '2021',
    '2020',
    '2019',
    '2018',
    '2017',
    '2016',
    '2015',
    '2014',
    '2013',
    '2012',
    '2011',
    '2010',
  ];
  static List<String> tabela = [];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: ListView.separated(
            itemBuilder: (BuildContext context, int anos) {
              return Text('');
            },
            padding: EdgeInsets.all(16),
            separatorBuilder: (_, ___) => Divider(),
            itemCount: ano.length));
  }
}
