import os
import pickle
def save_pkl(data, outfile):
    with open(outfile, mode='wb') as file:
        pickle.dump(data, file)
        file.close()


def load_pkl(infile):
    with open(infile, mode='rb') as file:
        data = pickle.load(file)
        file.close()
        
    return data


def read_file(infile):
    return (open(infile)).read()


# preprocessing data
from string import digits
def remove_digits(text):
    
    remove = str.maketrans('', '', digits)
    result_text = text.translate(remove)
    
    return result_text


import re
def preprocess_tokenized_text(tokenized_text, stop_words):
    """Tokenized Text: are text that have been tokenized using VnCoreNLP
    Stop words: pre-defined stop words list"""
        
    text = remove_digits(tokenized_text)

    tokens = text.split('\n')
    tokens_new = list()
    for token in tokens:
        # remove special characters in the text
        token_temp = re.sub('[″…‘’\[\]\{\}\`\~\|\'\!\@\#\$\%\^\&\*\(\)\+\=\<\>\?\,\.\/\:\\\\“\”\;\"]+', '', token)
        # remove spaces and some "weird" parterns at the beginning
        token_temp = re.sub('\ +', '',token_temp)
        token_temp = re.sub('^[–—\_\-]+', '',token_temp)
        token_temp = re.sub('[\\u200b]+', '', token_temp)
        token_temp = re.sub('[\\u2008]+', '', token_temp)
        # remove stop words and empty tokens from token list
        if token_temp not in stop_words and len(token_temp) !=0:
            tokens_new += [token_temp]
        
    return tokens_new


import pandas as pd
def to_df(tfidf_texts, feature_names):
    doc_names = ['Doc{:d}'.format(idx) for idx, _ in enumerate(tfidf_texts)]
    df = pd.DataFrame(data=tfidf_texts.toarray(), index=doc_names, columns=feature_names)

    return df
