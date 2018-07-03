package br.com.tuiuti.swapgames.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.tuiuti.swapgames.databinding.ItemFeedBinding;
import br.com.tuiuti.swapgames.model.Busca;
import br.com.tuiuti.swapgames.util.Log;

public class FeedRecyclerViewAdapter extends RecyclerView.Adapter<FeedRecyclerViewAdapter.ViewHolder> {

    private final List<Busca> mList;

    public FeedRecyclerViewAdapter(List<Busca> feeds) { mList = feeds; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        Log.d("FeedFragment.trataRespostaOk VIEW HOLDER!");

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemFeedBinding binding = ItemFeedBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final  int position) {
        final Busca feed = mList.get(position);

        Log.d("FeedFragment.trataRespostaOk - >>> !!!" + feed.getNome());

        holder.bind(feed);
    }

    @Override
    public int getItemCount() {

        Log.d("FeedFragment.trataRespostaOk - SIZEEE !!!" + mList.size());

        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemFeedBinding mBinding;

        ViewHolder(ItemFeedBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(Busca feed) {
            mBinding.setBusca(feed);
            mBinding.executePendingBindings();
        }
    }
}
